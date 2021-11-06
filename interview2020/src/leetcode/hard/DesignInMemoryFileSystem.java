package leetcode.hard;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/design-in-memory-file-system/discuss/103331/Java-Solution-File-class
public class DesignInMemoryFileSystem {
    class File {
        String name;
        StringBuffer content;
        boolean isFile;
        HashMap<String, File> children;

        File(String name) {
            this.name = name;
            content = new StringBuffer();
            children = new HashMap<>();
        }

    }

    File root;

    public DesignInMemoryFileSystem() {
        root = new File("");
    }

    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        List<String> result = new LinkedList<>();
        File node = root;

        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) return result;
            node = node.children.get(dir);
        }

        if (!node.isFile) {
            for (String file : node.children.keySet()) {
                result.add(file);
            }
        } else {
            result.add(node.name);
        }
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        mkdir(path, false);

    }

    private void mkdir(String path, boolean isFile) {
        String[] dirs = path.split("/");
        File node = root;
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) {
                File file = new File(dir);
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
        if (isFile) {
            node.isFile = true;
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        File node = root;

        for (String dir : dirs) {
            if (!node.children.containsKey(dir)) {
                mkdir(filePath, true);
            }
            node = node.children.get(dir);
        }
        if (node.isFile) {
            node.content.append(content);
        }
    }

    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        File node = root;

        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) return "";
            node = node.children.get(dir);
        }
        if (node.isFile) {
            return node.content.toString();
        }
        return "";

    }
}
