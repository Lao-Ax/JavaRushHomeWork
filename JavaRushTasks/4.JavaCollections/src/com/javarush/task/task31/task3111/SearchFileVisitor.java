package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (fileContainsPartOfName(file)
                && fileContainsPartOfContent(file)
                && fileIsMinThan(file)
                && fileIsMoreThan(file)
                ) {
            addFileToList(file);
        }
        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    private void addFileToList(Path file) {
        if (!foundFiles.contains(file)) {
            foundFiles.add(file);
        }
    }

    private boolean fileContainsPartOfName(Path file) {
        if (partOfName == null) {
            return true;
        } else {
            return file.toString().toLowerCase().contains(partOfName.toLowerCase());
        }
    }

    private boolean fileContainsPartOfContent(Path file) {
        if (partOfContent == null) {
            return true;
        } else {
            List<String> list = new ArrayList<>();
            try {
                list = Files.readAllLines(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list.stream().anyMatch(line -> line.contains(partOfContent));
        }
    }

    private boolean fileIsMoreThan(Path file) {
        if (maxSize == 0) {
            return true;
        } else {
            try {
                return Files.size(file) < maxSize;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    private boolean fileIsMinThan(Path file) {
        if (minSize == 0) {
            return true;
        } else {
            try {
                return Files.size(file) > minSize;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
