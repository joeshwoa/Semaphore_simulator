import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
    JButton start = new JButton("Start Producer");
    ActionListener start_action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            N_string = N.getText();
            buffer_size_string = buffer_size.getText();
            output_file_string = output_file.getText();
            if (N_string != null && buffer_size_string != null && output_file_string != null)
            {
                try {
                    N_long = Integer.parseUnsignedInt(N_string);
                    buffer_size_int = Integer.parseInt(buffer_size_string);
                    Main.buffer = new Buffer(buffer_size_int);
                    Main.semaphore = new Semaphore(buffer_size_int);
                    Main.creater = new CreateFile(output_file_string);
                    Main.writer = new WriteToFile(output_file_string);
                    Main.primes = new Counter();
                    Main.timer = new Timer();
                    Main.producer = new Producer(N_long);
                    Main.consumer = new Consumer();
                }catch (NumberFormatException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    };
    JTextField N = new JTextField();
    JTextField buffer_size = new JTextField();
    JTextField output_file = new JTextField();
    static JTextField largest = new JTextField();
    static JTextField counter = new JTextField();
    static JTextField timer = new JTextField();
    static JLabel N_label = new JLabel("N");
    static JLabel buffer_size_label = new JLabel("Buffer Size");
    static JLabel output_file_label = new JLabel("Output File");
    static JLabel largest_label = new JLabel("the largest prime number");
    static JLabel counter_label = new JLabel("# of elements (primes number) generated");
    static JLabel timer_label = new JLabel("time elapsed since the start of processing");
    String N_string ;
    String buffer_size_string ;
    String output_file_string ;
    long  N_long ;
    int buffer_size_int ;

    public Gui()
    {
        JFrame screen = new JFrame();
        Container container = screen.getContentPane();
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);

        start.addActionListener(start_action);
        largest.setEditable(false);
        counter.setEditable(false);
        timer.setEditable(false);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.preferredLayoutSize(container);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(N)
                                .addComponent(buffer_size)
                                .addComponent(output_file)
                                .addComponent(largest_label)
                                .addComponent(counter_label)
                                .addComponent(timer_label)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(start)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(N_label)
                                .addComponent(buffer_size_label)
                                .addComponent(output_file_label)
                                .addComponent(largest)
                                .addComponent(counter)
                                .addComponent(timer)
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(N)
                                .addComponent(N_label)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buffer_size)
                                .addComponent(buffer_size_label)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(output_file)
                                .addComponent(output_file_label)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(start)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(largest)
                                .addComponent(largest_label)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(counter)
                                .addComponent(counter_label)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(timer)
                                .addComponent(timer_label)
                        )
        );
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.pack();
        screen.setVisible(true);
    }
    public static void SetLookAndFeel()
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {

        }
    }
    public static void Setlargest (String num)
    {
        Gui.largest.setText(num);
    }
    public static void SetCounter (String num)
    {
        Gui.counter.setText(num);
    }
    public static void SetTime (String num)
    {
        Gui.timer.setText(num);
    }
}
