import java.math.BigDecimal;
import java.util.ArrayList;
import java.text.DecimalFormat;

class Id110103 implements Runnable {
	public void run() {
        int maxLength = 1024;
        String line;
        int total_student_count = 0;
        int student_count = 0;
        boolean is_total_student_count = true;
        ArrayList<BigDecimal> dollars = new ArrayList<BigDecimal>();
        ArrayList<BigDecimal> results = new ArrayList<BigDecimal>();

        while ((line = Main.ReadLn(maxLength)) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            if(is_total_student_count) {
            	total_student_count = Integer.valueOf(line);
            	if(total_student_count == 0) {
            		break;
            	}
            	is_total_student_count = false;
            } else {
            	dollars.add(new BigDecimal(line));
            	student_count++;

            	if(total_student_count == student_count) {
            		results.add(get_result(student_count, dollars));

            		dollars.clear();
            		is_total_student_count = true;
            		student_count = 0;
            	}
            }

        }

        for(int i=0; i<results.size(); i++) {
        	System.out.println("$" + new DecimalFormat("#.00").format(results.get(i).doubleValue()));
        }

    }

	private BigDecimal get_result(int student_count, ArrayList<BigDecimal> dollars) {
		BigDecimal total = new BigDecimal(0.0);
		BigDecimal result = new BigDecimal(0.0);

		for(int i=0; i<dollars.size(); i++) {
			total = total.add(dollars.get(i));
		}

		DecimalFormat df = new DecimalFormat("0.00");
		BigDecimal avg = new BigDecimal(new DecimalFormat("0.000").format(total.divide(new BigDecimal(student_count)).doubleValue()));

		for(int i=0; i<dollars.size(); i++) {
			if(avg.doubleValue() < dollars.get(i).doubleValue()) {
				result = result.add(new BigDecimal(df.format(dollars.get(i).doubleValue() - avg.doubleValue())));
			}
		}

		return result;
	}
}
