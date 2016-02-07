package it.dfalciglia.utilities.backup.impl;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import mockit.Tested;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileRetrieverOnLocalFileSystemTest {

  protected static final Logger LOGGER = LoggerFactory.getLogger(FileRetrieverOnLocalFileSystemTest.class);

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Tested
  protected FileRetrieverOnLocalFileSystem fileRetriever;

  @Test
  public void notExistingPath() {
    thrown.expect(IllegalArgumentException.class);
    fileRetriever.listFiles(Paths.get("/cartellainventata"));
  }

  // @Test
  // public void notReadablePath() {
  // try {
  // fileRetriever.listFiles(Paths.get(resourcePathOnTest("notToRead")));
  // }catch(IllegalArgumentException e) {
  // LOGGER.info(e.getMessage());
  // return;
  // }
  // Assert.fail("Expected IllegalArgumentException");
  // }

  @Test
  public void structuredPath() throws URISyntaxException {
    String dirTest = resourcePathOnTest("dirTest");
    List<File> found = fileRetriever.listFiles(dirTest);
  }

  private String resourcePathOnTest(String resourceName) {
    return this.getClass().getClassLoader().getResource(resourceName).toString().replace("file:", "");
  }

}
