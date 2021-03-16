package com.kotlin.action.ch06.java;

import java.io.File;
import java.util.List;

public interface FileContentProcessor {
    void processContents(File path,
                         byte[] binaryContents,
                         List<String> textContents);
}