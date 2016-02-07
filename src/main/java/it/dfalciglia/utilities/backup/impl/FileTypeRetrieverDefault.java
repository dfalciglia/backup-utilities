package it.dfalciglia.utilities.backup.impl;

import it.dfalciglia.utilities.backup.interfaces.FileTypeRetriever;

import java.util.Map;

import com.google.common.io.Files;

public class FileTypeRetrieverDefault implements FileTypeRetriever {

  private Map<String, FileType> configuration;

  @Override
  public void configure(Map<String, FileType> configuration) {
    this.configuration = configuration;
  }

  @Override
  public FileType getFileType(String filename) {
    String extension = Files.getFileExtension(filename);
    return configuration.get(extension);
  }

}
