package it.dfalciglia.utilities.backup.impl;

import it.dfalciglia.utilities.backup.interfaces.FileRetriever;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Preconditions;

public class FileRetrieverOnLocalFileSystem implements FileRetriever {

  @Override
  public List<File> listFiles(String rootPath) {
    Preconditions.checkNotNull(rootPath, "dirPath parameter can't be null.");
    Path path = Paths.get(rootPath);
    return listFiles(path);
  }

  @Override
  public List<File> listFiles(Path rootPath) {
    Preconditions.checkNotNull(rootPath, "dirPath parameter can't be null.");
    Preconditions.checkArgument(Files.exists(rootPath), rootPath + " isn't a valid path.");
    Preconditions.checkArgument(Files.isDirectory(rootPath), rootPath + " isn't a directory.");
    return new LinkedList<>();
  }

}
