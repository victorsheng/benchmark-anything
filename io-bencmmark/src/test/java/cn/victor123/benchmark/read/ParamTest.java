package cn.victor123.benchmark.read;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized.Parameters;

public class ParamTest {

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
    });
  }




}
