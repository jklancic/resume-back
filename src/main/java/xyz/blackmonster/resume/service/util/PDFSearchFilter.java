package xyz.blackmonster.resume.service.util;

import java.io.File;
import java.io.FileFilter;

public class PDFSearchFilter implements FileFilter {

    private static String FILE_ROOT_WORDING = "resume";

    @Override
    public boolean accept(File file) {
        return file.getName().startsWith(FILE_ROOT_WORDING);
    }
}
