package it.dfalciglia.utilities.backup.interfaces;

import java.util.Map;

public interface FileTypeRetriever {

  public enum FileType {
    DOCUMENT,
    IMAGE,
    VIDEO,
    ARCHIVE
  }

  void configure(Map<String, FileType> configuration);

  FileType getFileType(String filename);

}
