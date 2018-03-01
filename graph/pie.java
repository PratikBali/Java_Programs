import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class pie
{
public static void main(String arg[])
{
  DefaultPieDataset pieDataset = new DefaultPieDataset();
  pieDataset.setValue("One", new Integer(10));
  pieDataset.setValue("Two", new Integer(20));
  pieDataset.setValue("Three", new Integer(30));
  pieDataset.setValue("Four", new Integer(10));
  pieDataset.setValue("Five", new Integer(20));
  pieDataset.setValue("Six", new Integer(10));
  JFreeChart chart = ChartFactory.createPieChart("Pie Chart using JFreeChart", pieDataset, true,true,true);

  ChartFrame frame1=new ChartFrame("Pie Chart",chart);
  frame1.setVisible(true);
  frame1.setSize(600,600);
  frame1.setLocation(300, 50);
  }
}