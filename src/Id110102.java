class Id110102 implements Runnable {
	public void run() {
        int maxLength = 1024;
        String line;

        int row = -1;
        int column = -1;
        int field_count = 0;
        int row_index = 0;
        String[] lines = null;
        String output = "";

        while ((line = Main.ReadLn(maxLength)) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            if(row == -1 && column == -1) {
            	String[] splitLine = line.split("\\s+");
            	row = Integer.valueOf(splitLine[0]);
            	column = Integer.valueOf(splitLine[1]);

            	if(row == 0 && column == 0) {
            		break;
            	}

            	field_count++;
            	continue;
            }

            if(lines == null) {
            	lines = new String[row];
            }

            lines[row_index] = line;
            row_index++;

            if(row_index == row) {
            	output += output(field_count, solve(lines));
            	row_index = 0;
            	lines = null;
            	row = -1;
            	column = -1;
            }
        }

        System.out.println(output);
    }

	private String[] solve(String[] lines) {
		int rows = lines.length;
		String[] result = new String[rows];
		for(int i=0; i<rows; i++) {
			result[i] = "";
		}
		for(int i=0; i<rows; i++) {
			String line = lines[i];
			int columns = line.length();
			int number = 0;

			for(int j=0; j<columns; j++) {
				if(line.charAt(j) == '*') {
					result[i] += "*";
				} else {
					for(int _i = i - 1; _i <= i + 1; _i++) {
						if(_i < 0 || _i > rows - 1) {
							continue;
						}

						String _rows = lines[_i];
						for(int _j = j - 1; _j <= j + 1; _j++) {
							if(_j < 0 || _j > columns - 1) {
								continue;
							}

							if(_i == i && _j == j) {
								continue;
							}

							if(_rows.charAt(_j) == '*') {
								number++;
							}
						}
					}

					result[i] += Integer.toString(number);
					number = 0;
				}
			}
		}

		return result;
	}

	private String output(int field_count, String[] result) {
		String output = "\nField #" + field_count + ":\n";
		for(int i=0; i<result.length; i++) {
			output += result[i] + "\n";
		}

		return output;
	}
}
