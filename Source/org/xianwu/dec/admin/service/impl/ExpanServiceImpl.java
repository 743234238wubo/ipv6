package org.xianwu.dec.admin.service.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.xianwu.core.metatype.Dto;
import org.xianwu.core.metatype.impl.BaseDto;
import org.xianwu.core.model.service.impl.BizServiceImpl;
import org.xianwu.core.orm.xibatis.sqlmap.client.SqlMapExecutor;
import org.xianwu.core.orm.xibatis.support.SqlMapClientCallback;
import org.xianwu.dec.admin.service.ExpanService;
import org.xianwu.dec.admin.service.Hd_toolholder_tappingService;
import org.xianwu.system.common.util.idgenerator.MaxId;

/**
 * 丝锥
 *
 * @author XianwuFu
 * @since 2013-01-01
 */
public class ExpanServiceImpl extends BizServiceImpl implements ExpanService {

	/**
	 * 保存
	 *
	 * @param pDto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Dto saveExpan(Dto pDto) {
		Dto outDto = new BaseDto();
		//pDto.put("Hd_toolholder_boringid", MaxId.getHd_toolholder_boringID());
		
		String expanid = MaxId.getExpanid();
		
		pDto.put("expanid", expanid);
		g4Dao.insert("Expan.saveExpan", pDto);
	/*	pDto.put("typeid", hd_toolholder_tappingID);
		pDto.put("toolholderid", MaxId.getHd_holedrillingID());*/
	/*	g4Dao.insert("Hd_toolholder_tapping.saveHd_holedrilling", pDto);*/
		
		outDto.put("msg", "扩大问题添加成功！");
		outDto.put("success", new Boolean(true));
		return outDto;
	}
	
	public Dto saveKeyp(Dto pDto) {
		Dto outDto = new BaseDto();
		//pDto.put("Hd_toolholder_boringid", MaxId.getHd_toolholder_boringID());
		
		String keyid = MaxId.getKeyid();
		
		pDto.put("keyid", keyid);
		g4Dao.insert("Expan.saveKeyp", pDto);
	/*	pDto.put("typeid", hd_toolholder_tappingID);
		pDto.put("toolholderid", MaxId.getHd_holedrillingID());*/
	/*	g4Dao.insert("Hd_toolholder_tapping.saveHd_holedrilling", pDto);*/
		
		outDto.put("msg", "核心问题添加成功！");
		outDto.put("success", new Boolean(true));
		return outDto;
	}
	
	
	public Dto savePrevent(Dto pDto) {
		Dto outDto = new BaseDto();
		//pDto.put("Hd_toolholder_boringid", MaxId.getHd_toolholder_boringID());
		
		String preventid = MaxId.getPreventid();
		
		pDto.put("preventid", preventid);
		g4Dao.insert("Expan.savePrevent", pDto);
	/*	pDto.put("typeid", hd_toolholder_tappingID);
		pDto.put("toolholderid", MaxId.getHd_holedrillingID());*/
	/*	g4Dao.insert("Hd_toolholder_tapping.saveHd_holedrilling", pDto);*/
		
		outDto.put("msg", "阻止问题添加成功！");
		outDto.put("success", new Boolean(true));
		return outDto;
	}
	
	public Dto saveMethod(Dto pDto) {
		Dto outDto = new BaseDto();
		//pDto.put("Hd_toolholder_boringid", MaxId.getHd_toolholder_boringID());
		
		String methodid = MaxId.getMethodid();
		
		pDto.put("methodid", methodid);
		g4Dao.insert("Expan.saveMethod", pDto);
	/*	pDto.put("typeid", hd_toolholder_tappingID);
		pDto.put("toolholderid", MaxId.getHd_holedrillingID());*/
	/*	g4Dao.insert("Hd_toolholder_tapping.saveHd_holedrilling", pDto);*/
		
		outDto.put("msg", "原因及其他方法添加成功！");
		outDto.put("success", new Boolean(true));
		return outDto;
	}
	
	
	
	
	public Dto saveReduce(Dto pDto) {
		Dto outDto = new BaseDto();
		//pDto.put("Hd_toolholder_boringid", MaxId.getHd_toolholder_boringID());
		
		String reduceid = MaxId.getReduceid();
		
		pDto.put("reduceid", reduceid);
		g4Dao.insert("Expan.saveReduce", pDto);
	/*	pDto.put("typeid", hd_toolholder_tappingID);
		pDto.put("toolholderid", MaxId.getHd_holedrillingID());*/
	/*	g4Dao.insert("Hd_toolholder_tapping.saveHd_holedrilling", pDto);*/
		
		outDto.put("msg", "缩小问题添加成功！");
		outDto.put("success", new Boolean(true));
		return outDto;
	}
	/**
	 * 批量保存丝锥
	 *
	 * @param pDto
	 * @return
	 */
	public Dto batchSaveHd_toolholder_tapping(final List<Dto> dataList) {
		final Dto outDto = new BaseDto();
		g4Dao.getSqlMapClientTpl().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (int i = 0; i < dataList.size(); i++) {
					Dto dto3 = (Dto) dataList.get(i);
					String temp = MaxId.getHd_toolholder_tappingID();
					dto3.put("hdttid",temp);
					dto3.put("typeid", temp);
					dto3.put("toolholderid", MaxId.getHd_holedrillingID());
					executor.insert("Hd_toolholder_tapping.saveHd_holedrilling", dto3);
					executor.insert("Hd_toolholder_tapping.saveHd_toolholder_tapping", dto3);
				}
				
				executor.executeBatch();
				
				outDto.put("msg", "批量导入丝锥成功！");
				outDto.put("success", true);
				return null;
			}
		});
		return outDto;
	}
	/**
	 * 插入机夹刀具刀片
	 *
	 * @param pDto
	 * @return
	 */
	public Dto insertHd_toolholder_tapping(Dto pDto) {
		return saveExpan(pDto);
	}

	/**
	 * 删除机夹刀具刀片
	 *
	 * @param pDto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Dto deleteHd_toolholder_tapping(Dto pDto) {
		Dto dto = new BaseDto();
		String[] arrChecked = pDto.getAsString("strChecked").split(",");
		Dto dtoKey = null;
		
		for (int i = 0; i < arrChecked.length; i++) {
			dto.put("toolholderid", arrChecked[i]);
			
			List typeid =  g4Dao.queryForList("Hd_toolholder_tapping.queryTypeid4Delete", dto);
			
			g4Dao.delete("Hd_toolholder_tapping.deleteHd_holedrilling", dto);
			
			// g4Dao.update("Hd_toolholder_boring.updateMachinetoolholder4Hd_toolholder_boring", dto);
			// g4Dao.update("Hd_toolholder_boring.updateBladetoolholder4Hd_toolholder_boring", dto);

			Iterator<Dto> typeid_it = typeid.iterator();
			while (typeid_it.hasNext()) {
				 dtoKey = typeid_it.next();
				 //dto.put("typeid", dtoKey.get("typeid"));
			}
			g4Dao.delete("Hd_toolholder_tapping.deleteHd_toolholder_tapping", dtoKey); 
		}
		return null;
	}

	/**
	 * 修改丝锥
	 *
	 * @param pDto
	 * @return
	 */
	public Dto updateHd_toolholder_tapping(Dto pDto) {

		List typeid = g4Dao.queryForList("Hd_toolholder_tapping.queryTypeid4Update", pDto);
		

		Iterator<Dto> typeid_it = typeid.iterator();
		Dto dtoKey = null;
		while (typeid_it.hasNext()) {
			 dtoKey = typeid_it.next();
			 //dto.put("typeid", dtoKey.get("typeid"));
			 
			 pDto.put("typeid", dtoKey.get("typeid"));
			 g4Dao.update("Hd_toolholder_tapping.updateHd_holedrilling", pDto);
			 g4Dao.update("Hd_toolholder_tapping.updateHd_toolholder_tapping", pDto);
		}

		return null;
	}


	public Dto saveMainTable(Dto dto){
		g4Dao.update("Hd_toolholder_tapping.saveMainTable", dto);
		return null;
	}

	
	public Dto saveSubTable(Dto dto){
		g4Dao.update("Hd_toolholder_tapping.saveSubTable", dto);
		return null;
	}
	
	


}
