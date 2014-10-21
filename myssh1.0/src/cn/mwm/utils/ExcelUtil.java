package cn.mwm.utils;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddressList;

/**
 * 
 * @ClassName: ExcelUtil
 * @Description: TODO(excel����롢����������)
 * @author Ma_2014 ma_swun092@163.com
 * @date 2014-10-17 ����11:06:37
 * 
 */
public class ExcelUtil<T> {

	Class<T> clazz;

	public ExcelUtil(Class<T> clazz) {
		this.clazz = clazz;
	}

	public boolean doExportExcel(List<T> list, String sheetName, int sheetSize,
			OutputStream out) {

		// ��ȡ���е��ֶ�
		Field[] allFields = clazz.getDeclaredFields();
		List<Field> fieldList = new ArrayList<Field>();
		// �õ��ֶηŵ�List��
		for (Field field : allFields) {
			if (field.isAnnotationPresent(ExcelVOAttribute.class)) {
				fieldList.add(field);
			}
		}

		HSSFWorkbook workbook = new HSSFWorkbook();// ��������������

		// excel2003��ÿ��sheet�������65536��,Ϊ��������������Լ�����߼�.
		if (sheetSize > 65536 || sheetSize < 1) {
			sheetSize = 65536;
		}

		double sheetNum = Math.ceil(list.size() / sheetSize);// ȡ��һ���ж��ٸ�sheet.

		for (int index = 0; index <= sheetNum; index++) {

			HSSFSheet sheet = workbook.createSheet();// �������������
			workbook.setSheetName(index, sheetName + index);// ���ù����������.
			HSSFRow row;
			HSSFCell cell;// ������Ԫ��

			row = sheet.createRow(0);// ����һ��
			// д������ֶε���ͷ����
			for (int i = 0; i < fieldList.size(); i++) {
				Field field = fieldList.get(i);
				ExcelVOAttribute attr = field
						.getAnnotation(ExcelVOAttribute.class);
				int col = getExcelCol(attr.column());// ����к�
				cell = row.createCell(col);// ������
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);// ��������д������ΪString����
				cell.setCellValue(attr.name());// д������

				// �����������ʾ��Ϣ��������ȥ��ʾ.
				if (!attr.prompt().trim().equals("")) {
					setHSSFPrompt(sheet, "", attr.prompt(), 1, 100, col, col);// ����Ĭ������2-101����ʾ.
				}
				// ���������combo��������ֻ��ѡ��������
				if (attr.combo().length > 0) {
					setHSSFValidation(sheet, attr.combo(), 1, 100, col, col);// ����Ĭ������2-101��ֻ��ѡ��������.
				}
			}

			int startNo = index * sheetSize;
			int endNo = Math.min(startNo + sheetSize, list.size());
			// д�������¼,ÿ����¼��Ӧexcel���е�һ��
			for (int i = startNo; i < endNo; i++) {
				row = sheet.createRow(i + 1 - startNo);
				T vo = (T) list.get(i); // �õ���������.
				for (int j = 0; j < fieldList.size(); j++) {
					Field field = fieldList.get(j);// ���field.
					field.setAccessible(true);// ����ʵ����˽�����Կɷ���
					ExcelVOAttribute attr = field
							.getAnnotation(ExcelVOAttribute.class);
					try {
						// ����ExcelVOAttribute��������������Ƿ񵼳�,��Щ�����Ҫ����Ϊ��,ϣ���û���д��һ��.
						if (attr.isExport()) {
							cell = row.createCell(getExcelCol(attr.column()));// ����cell
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							cell.setCellValue(field.get(vo) == null ? ""
									: String.valueOf(field.get(vo)));// ������ݴ��ھ�����,����������ո�.
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return false;
	}

	/**
	 * ��EXCEL��A,B,C,D,E��ӳ���0,1,2,3
	 * 
	 * @param col
	 */
	public static int getExcelCol(String col) {
		col = col.toUpperCase();
		// ��-1��ʼ����,��ĸ��1��ʼ���㡣����������������������ͬ��
		int count = -1;
		char[] cs = col.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
		}
		return count;
	}

	/**
	 * ���õ�Ԫ������ʾ
	 * 
	 * @param sheet
	 *            Ҫ���õ�sheet.
	 * @param promptTitle
	 *            ����
	 * @param promptContent
	 *            ����
	 * @param firstRow
	 *            ��ʼ��
	 * @param endRow
	 *            ������
	 * @param firstCol
	 *            ��ʼ��
	 * @param endCol
	 *            ������
	 * @return ���úõ�sheet.
	 */
	public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle,
			String promptContent, int firstRow, int endRow, int firstCol,
			int endCol) {
		// ����constraint����
		DVConstraint constraint = DVConstraint
				.createCustomFormulaConstraint("DD1");
		// �ĸ������ֱ��ǣ���ʼ�С���ֹ�С���ʼ�С���ֹ��
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// ������Ч�Զ���
		HSSFDataValidation data_validation_view = new HSSFDataValidation(
				regions, constraint);
		data_validation_view.createPromptBox(promptTitle, promptContent);
		sheet.addValidationData(data_validation_view);
		return sheet;
	}

	/**
	 * ����ĳЩ�е�ֵֻ������Ԥ�Ƶ�����,��ʾ������.
	 * 
	 * @param sheet
	 *            Ҫ���õ�sheet.
	 * @param textlist
	 *            ��������ʾ������
	 * @param firstRow
	 *            ��ʼ��
	 * @param endRow
	 *            ������
	 * @param firstCol
	 *            ��ʼ��
	 * @param endCol
	 *            ������
	 * @return ���úõ�sheet.
	 */
	public static HSSFSheet setHSSFValidation(HSSFSheet sheet,
			String[] textlist, int firstRow, int endRow, int firstCol,
			int endCol) {
		// ���������б�����
		DVConstraint constraint = DVConstraint
				.createExplicitListConstraint(textlist);
		// ����������Ч�Լ������ĸ���Ԫ����,�ĸ������ֱ��ǣ���ʼ�С���ֹ�С���ʼ�С���ֹ��
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// ������Ч�Զ���
		HSSFDataValidation data_validation_list = new HSSFDataValidation(
				regions, constraint);
		sheet.addValidationData(data_validation_list);
		return sheet;
	}

}
