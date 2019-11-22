package proxy;

import mystring.IndiscreetString;
import mystring.MyString;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscreetString implements MyString {
    IndiscreetString str = new IndiscreetString();
    int count=0;

    public DiscreetString() {}

    @Override
    public void setText(String s) {
        str.setText(s);
    }

    @Override
    public String getText() {
        String modStr = str.getText();

        // replacements map
        Map<String, String> rep = new HashMap<>();
        rep.put("bum", "b*m");
        rep.put("weewee", "w**w**");
        rep.put("knickers", "kn*ckers");
        rep.put("poopoos", "p**p**s");

        // Create pattern of the format "(bum|weewee|knickers|poopoos)"
        String patternString = "(bum|weewee|knickers|poopoos)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(modStr);

        // Replace the matched patterns
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(sb, rep.get(matcher.group()));
            count++;
        }
        matcher.appendTail(sb);
        modStr = sb.toString();
        System.out.println(modStr);
        str.setText(modStr);

        return modStr;
    }

    @Override
    public void clear() {
        str.clear();
    }

    @Override
    public void reverse() {
        String t = "";

        for(int i = str.getText().length() - 1; i >= 0; --i) {
            t = t + str.getText().charAt(i);
        }
        System.out.println(t);
    }

    public void close() {
        System.out.println(String.format("The user attempted to insert %d naughty words", count));
    }

}
