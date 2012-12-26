class Id110102 implements Runnable {
	public void run() {
        int maxLength = 1024;
        String line;

        int row = -1;
        int column = -1;
        boolean is_row_column = true;
        int field_count = 0;
        int row_index = 0;
        String[] lines = null;
        String output = "";

        while ((line = Main.ReadLn(maxLength)) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            if(is_row_column) {
            	is_row_column = false;
            	String[] splitLine = line.split("\\s+");
            	row = Integer.valueOf(splitLine[0]);
            	column = Integer.valueOf(splitLine[1]);
            	lines = new String[row];

            	if(row == 0 && column == 0) {
            		break;
            	}

            	field_count++;
            	continue;
            }

            lines[row_index] = line;
            row_index++;

            if(row_index == row) {
            	output += output(field_count, solve(lines));
            	row_index = 0;
            	is_row_column = true;
            }
        }

        System.out.println(output);
    }

	/**
	 * ¹®Á¦ ÇØ°á
	 * @param lines : ÀÔ·Â ¹ÞÀº Áö·Ú¹ç
	 * @return
	 */
	private String[] solve(String[] lines) {
		int rows = lines.length;
		String[] result = new String[rows];
		for(int i=0; i<rows; i++) {
			result[i] = "";
		}
		for(int i=0; i<rows; i++) {
			String line = lines[i];
			int columns = line.length();

			for(int j=0; j<columns; j++) {
				if(line.charAt(j) == '*') {
					result[i] += "*";
				} else {
					result[i] += check_count(rows, columns, i, j, lines);
				}
			}
		}

		return result;
	}

	/**
	 * ÀÎÁ¢ÇØ ÀÖ´Â À§Ä¡¿¡ Áö·Ú°¡ ÀÖ´ÂÁö Ã¼Å©
	 * @param rows : ÃÑ row ¼ö
	 * @param columns : ÃÑ column ¼ö
	 * @param row : ÇöÀç row
	 * @param column : ÇöÀç column
	 * @param lines : Áö·Ú¹ç
	 * @return
	 */
	private String check_count(int rows, int columns, int row, int column, String[] lines) {
		int number = 0;
		for(int i = row - 1; i <= row + 1; i++) {
			if(i < 0 || i > rows - 1) {
				continue;
			}

			for(int j = column - 1; j <= column + 1; j++) {
				if(j < 0 || j > columns - 1 || (i == row && j == column)) {
					continue;
				}

				if(lines[i].charAt(j) == '*') {
					number++;
				}
			}
		}

		return Integer.toString(number);
	}

	/**
	 * Ãâ·Â ³»¿ë
	 * @param field_count : Áö·Ú¹ç No
	 * @param result
	 * @return
	 */
	private String output(int field_count, String[] result) {
		String output = (field_count > 1 ? "\n\n" : "") + "Field #" + field_count + ":";
		for(int i=0; i<result.length; i++) {
			output += "\n" + result[i];
		}

		return output;
	}
}
