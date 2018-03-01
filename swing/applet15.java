import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*<applet code="applet15" width=400 height=200></applet>*/

public class applet15 extends Applet implements ActionListener
    {
        List l1,l2;
        Button b1,b2;
        public void init()
            {
                setLayout(null);
                l1 = new List(15,true);
                l2 = new List(15,true);

                b1 = new Button(">>");
                b2= new Button("<<");

                add(l1);
                add(l2);
                add(b1);
                add(b2);

                l1.add("Windows 98");
                l1.add("windows 2000");
                l1.add("windows xp");
                l1.add("windows nt");

                l1.setBounds(10,10,150,200);
                l2.setBounds(225,10,150,200);

                b1.setBounds(170,70,40,40);
                b2.setBounds(170,125,40,40);
                b1.addActionListener(this);
                b2.addActionListener(this);
            }

    public void actionPerformed(ActionEvent e)
        {
        if(e.getSource()==b1)
        {
            int i;
            String s[] = l1.getSelectedItems();
            if(s.length != 0)
                {
                     for(i=0;i<s.length;i++)
                        {
                        l2.add(s[i]);
                        l1.remove(s[i]);
                        }
                  }
        }

        if(e.getSource()==b2)
                {
                    int i;
                    String s[] = l2.getSelectedItems();
                    if(s.length != 0)
                        {
                         for(i=0;i<s.length;i++)
                                {
                                l1.add(s[i]);
                                l2.remove(s[i]);
                                }
                        }
                }

        }
}
