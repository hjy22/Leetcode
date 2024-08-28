package Interview.tiktok;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class dataStructure {

    public static void main(String[] args) {
        // 示例嵌套结构
        String structure = "{'1' {'foo'}{'2' {'bar'}{'4'{} }}}";
        
        // 解析并转换为 Map
        Map<String, Object> resultMap = parseStructure(structure);
        
        // 打印结果
        System.out.println(resultMap);
    }
    
    public static Map<String, Object> parseStructure(String structure) {
        // 将结构字符串清理和标准化
        structure = structure.replace("{", "{ ").replace("}", " }").replace("'", "\"");
        
        // 创建一个解析器
        StringParser parser = new StringParser(structure);
        
        // 解析并返回结果 Map
        return parser.parse();
    }
    
    private static class StringParser {
        private String str;
        private int pos = 0;
        
        public StringParser(String str) {
            this.str = str;
        }
        
        public Map<String, Object> parse() {
            return parseMap();
        }
        
        private Map<String, Object> parseMap() {
            Map<String, Object> map = new HashMap<>();
            skipWhitespace();
            if (str.charAt(pos) == '{') {
                pos++; // Skip '{'
                while (str.charAt(pos) != '}') {
                    skipWhitespace();
                    String key = parseKey();
                    skipWhitespace();
                    Object value = parseValue();
                    map.put(key, value);
                    skipWhitespace();
                    if (str.charAt(pos) == '}') {
                        pos++;
                        break;
                    }
                }
            }
            return map;
        }
        
        private String parseKey() {
            skipWhitespace();
            int start = pos;
            while (str.charAt(pos) != ' ') {
                pos++;
            }
            return str.substring(start, pos).replace("\"", "");
        }
        
        private Object parseValue() {
            skipWhitespace();
            if (str.charAt(pos) == '{') {
                pos++; // Skip '{'
                Map<String, Object> nestedMap = parseMap();
                skipWhitespace();
                return nestedMap;
            } else if (str.charAt(pos) == '}') {
                return new HashMap<>(); // Empty map
            } else {
                int start = pos;
                while (str.charAt(pos) != ' ' && str.charAt(pos) != '}') {
                    pos++;
                }
                return new HashSet<>(Set.of(str.substring(start, pos).replace("\"", "")));
            }
        }
        
        private void skipWhitespace() {
            while (pos < str.length() && Character.isWhitespace(str.charAt(pos))) {
                pos++;
            }
        }
    }
}
