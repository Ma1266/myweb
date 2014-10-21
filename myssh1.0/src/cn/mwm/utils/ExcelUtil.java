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
 * @Description: TODO(excel表格导入、导出工具类)
 * @author Ma_2014 ma_swun092@163.com
 * @date 2014-10-17 上午11:06:37
 * 
 */
public class ExcelUtil<T> {

	Class<T> clazz;

	public ExcelUtil(Class<T> clazz) {
		this.clazz = clazz;
	}

	public boolean doExportExcel(List<T> list, String sheetName, int sheetSize,
			OutputStream out) {

		// 获取所有的字段
		Field[] allFields = clazz.getDeclaredFields();
		List<Field> fieldList = new ArrayList<Field>();
		// 得到字段放到List中
		for (Field field : allFields) {
			if (field.isAnnotationPresent(ExcelVOAttribute.class)) {
				fieldList.add(field);
			}
		}

		HSSFWorkbook workbook = new HSSFWorkbook();// 产生工作薄对象

		// excel2003中每个sheet中最多有65536行,为避免产生错误所以加这个逻辑.
		if (sheetSize > 65536 || sheetSize < 1) {
			sheetSize = 65536;
		}

		double sheetNum = Math.ceil(list.size() / sheetSize);// 取出一共有多少个sheet.

		for (int index = 0; index <= sheetNum; index++) {

			HSSFSheet sheet = workbook.createSheet();// 产生工作表对象
			workbook.setSheetName(index, sheetName + index);// 设置工作表的名称.
			HSSFRow row;
			HSSFCell cell;// 产生单元格

			row = sheet.createRow(0);// 产生一行
			// 写入各个字段的列头名称
			for (int i = 0; i < fieldList.size(); i++) {
				Field field = fieldList.get(i);
				ExcelVOAttribute attr = field
						.getAnnotation(ExcelVOAttribute.class);
				int col = getExcelCol(attr.column());// 获得列号
				cell = row.createCell(col);// 创建列
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);// 设置列中写入内容为String类型
				cell.setCellValue(attr.name());// 写入列名

				// 如果设置了提示信息则鼠标放上去提示.
				if (!attr.prompt().trim().equals("")) {
					setHSSFPrompt(sheet, "", attr.prompt(), 1, 100, col, col);// 这里默认设了2-101列提示.
				}
				// 如果设置了combo属性则本列只能选择不能输入
				if (attr.combo().length > 0) {
					setHSSFValidation(sheet, attr.combo(), 1, 100, col, col);// 这里默认设了2-101列只能选择不能输入.
				}
			}

			int startNo = index * sheetSize;
			int endNo = Math.min(startNo + sheetSize, list.size());
			// 写入各条记录,每条记录对应excel表中的一行
			for (int i = startNo; i < endNo; i++) {
				row = sheet.createRow(i + 1 - startNo);
				T vo = (T) list.get(i); // 得到导出对象.
				for (int j = 0; j < fieldList.size(); j++) {
					Field field = fieldList.get(j);// 获得field.
					field.setAccessible(true);// 设置实体类私有属性可访问
					ExcelVOAttribute attr = field
							.getAnnotation(ExcelVOAttribute.class);
					try {
						// 根据ExcelVOAttribute中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.
						if (attr.isExport()) {
							cell = row.createCell(getExcelCol(attr.column()));// 创建cell
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							cell.setCellValue(field.get(vo) == null ? ""
									: String.valueOf(field.get(vo)));// 如果数据存在就填入,不存在填入空格.
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
	 * 将EXCEL中A,B,C,D,E列映射成0,1,2,3
	 * 
	 * @param col
	 */
	public static int getExcelCol(String col) {
		col = col.toUpperCase();
		// 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。
		int count = -1;
		char[] cs = col.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
		}
		return count;
	}

	/**
	 * 设置单元格上提示
	 * 
	 * @param sheet
	 *            要设置的sheet.
	 * @param promptTitle
	 *            标题
	 * @param promptContent
	 *            内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 */
	public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle,
			String promptContent, int firstRow, int endRow, int firstCol,
			int endCol) {
		// 构造constraint对象
		DVConstraint constraint = DVConstraint
				.createCustomFormulaConstraint("DD1");
		// 四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_view = new HSSFDataValidation(
				regions, constraint);
		data_validation_view.createPromptBox(promptTitle, promptContent);
		sheet.addValidationData(data_validation_view);
		return sheet;
	}

	/**
	 * 设置某些列的值只能输入预制的数据,显示下拉框.
	 * 
	 * @param sheet
	 *            要设置的sheet.
	 * @param textlist
	 *            下拉框显示的内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 */
	public static HSSFSheet setHSSFValidation(HSSFSheet sheet,
			String[] textlist, int firstRow, int endRow, int firstCol,
			int endCol) {
		// 加载下拉列表内容
		DVConstraint constraint = DVConstraint
				.createExplicitListConstraint(textlist);
		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_list = new HSSFDataValidation(
				regions, constraint);
		sheet.addValidationData(data_validation_list);
		return sheet;
	}

}
