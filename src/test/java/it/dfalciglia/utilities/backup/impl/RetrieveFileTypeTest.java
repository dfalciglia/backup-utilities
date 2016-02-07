package it.dfalciglia.utilities.backup.impl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import it.dfalciglia.utilities.backup.interfaces.FileTypeRetriever.FileType;
import it.dfalciglia.utilities.backup.utils.UnitTest;

import java.util.HashMap;
import java.util.Map;

import mockit.Tested;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(UnitTest.class)
public class RetrieveFileTypeTest {

  @Tested(availableDuringSetup = true)
  FileTypeRetrieverDefault retrieveFileType;

  @Before
  public void init() {
    Map<String, FileType> configuration = new HashMap<>();
    configureExtensions(configuration, FileType.DOCUMENT, "aaa", "bbb", "cc");
    configureExtensions(configuration, FileType.IMAGE, "ddd", "eee");
    configureExtensions(configuration, FileType.VIDEO, "ttt", "ssss", "kkk");
    configureExtensions(configuration, FileType.ARCHIVE, "tt", "zz");
    retrieveFileType.configure(configuration);
  }

  @Test
  public void unknownType() {
    Assert.assertThat(retrieveFileType.getFileType("aaa.xyz"), nullValue());
  }

  @Test
  public void documentType() {
    Assert.assertThat(retrieveFileType.getFileType("aaa.aaa"), equalTo(FileType.DOCUMENT));
    Assert.assertThat(retrieveFileType.getFileType("aaa.bbb"), equalTo(FileType.DOCUMENT));
    Assert.assertThat(retrieveFileType.getFileType("aaa.cc"), equalTo(FileType.DOCUMENT));
    Assert.assertThat(retrieveFileType.getFileType("aaa.ll"), not(equalTo(FileType.DOCUMENT)));
    Assert.assertThat(retrieveFileType.getFileType("cc.vv"), not(equalTo(FileType.DOCUMENT)));
  }

  @Test
  public void imageType() {
    Assert.assertThat(retrieveFileType.getFileType("aaa.ddd"), equalTo(FileType.IMAGE));
    Assert.assertThat(retrieveFileType.getFileType("aaa.eee"), equalTo(FileType.IMAGE));
    Assert.assertThat(retrieveFileType.getFileType("ddd"), not(equalTo(FileType.IMAGE)));
    Assert.assertThat(retrieveFileType.getFileType("eee.ll"), not(equalTo(FileType.IMAGE)));
  }

  @Test
  public void videoType() {
    Assert.assertThat(retrieveFileType.getFileType("aaa.ttt"), equalTo(FileType.VIDEO));
    Assert.assertThat(retrieveFileType.getFileType("aaa.ssss"), equalTo(FileType.VIDEO));
    Assert.assertThat(retrieveFileType.getFileType("aaa.kkk"), equalTo(FileType.VIDEO));
  }

  @Test
  public void archiveType() {
    Assert.assertThat(retrieveFileType.getFileType("aaa.tt"), equalTo(FileType.ARCHIVE));
    Assert.assertThat(retrieveFileType.getFileType("aaa.kk.zz"), equalTo(FileType.ARCHIVE));
  }

  protected void configureExtensions(Map<String, FileType> configuration, FileType fileType, String... extensions) {
    for (String extension : extensions)
      configuration.put(extension, fileType);
  }
}
