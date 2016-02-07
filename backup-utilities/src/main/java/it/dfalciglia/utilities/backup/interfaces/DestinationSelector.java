package it.dfalciglia.utilities.backup.interfaces;

import java.io.File;
import java.nio.file.Path;

@FunctionalInterface
public interface DestinationSelector {

  Path selectDestination(File inputFile);

}
