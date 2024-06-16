# windriver-java-client

This is a Java language webdriver client that can be used with [WinDriver](https://github.com/pvhung97/WinDriver)

# Maven dependency

```
<dependency>
  <groupId>io.github.pvhung97</groupId>
  <artifactId>windriver-client</artifactId>
  <version>${version}</version>
</dependency>
```

# Sample usage

```
WinDriverOptions cap = new WinDriverOptions().setAumid("Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
RemoteWebDriver driver = new WinDriver(new URL("http://localhost:5000"), cap);
try {
    driver.findElement(new AutomationIdBy("num5Button")).click();
} finally {
    driver.quit();
}
```

Check the [WinDriver](https://github.com/pvhung97/WinDriver)'s READMEs to know the list of capabilities and features it supports.