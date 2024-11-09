package userData;

import ultilities.FakerConfig;

import java.util.ArrayList;
import java.util.List;

public class OrdersData {
    private String ram;
    private String hdd;
    private String os;
    private String processor;
    private List<String> softwareList;
    private String productName;
    private String quantity;

    public OrdersData (String processor, String ram, String hdd, String os,List<String> softwareList){
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.softwareList = softwareList;
    }

    // getExpected result

    public String getExpectedResult(){
        String expectedResult =
                "Processor: " + processor +"\n" +
                "RAM: " + ram +"\n" +
                "HDD: " + hdd +"\n" +
                "OS: " + os +"\n" +
                expectedSoftwareList();
        return expectedResult;
    }

    public String expectedSoftwareList() {
        String expectedSoftware = "";
        for (String software : softwareList){
            expectedSoftware = expectedSoftware+ "Software: "+software + "\n";
        }
        return expectedSoftware.trim();
    }

    // getter

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public List<String> getSoftwareList() {
        return softwareList;
    }

    public String getProcessor() {
        return processor;
    }
}
