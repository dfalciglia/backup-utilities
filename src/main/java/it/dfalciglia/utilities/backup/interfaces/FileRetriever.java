package it.dfalciglia.utilities.backup.interfaces;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface FileRetriever {

  List<File> listFiles(Path rootPath);

  List<File> listFiles(String rootPath);

}
