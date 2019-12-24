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
import org.xianwu.dec.admin.service.NetbrainstormService;
import org.xianwu.system.common.util.idgenerator.MaxId;

/**
 * 丝锥
 *
 * @author XianwuFu
 * @since 2013-01-01
 */
public class NetbrainstormServiceImpl extends BizServiceImpl implements NetbrainstormService {

	/**
	 * 保存
	 *
	 * @param pDto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Dto saveNetbrainstorm(Dto pDto) {
		Dto outDto = new BaseDto();
		String netbrainstormid = MaxId.getNetbrainstormid();
		pDto.put("netbrainstormID", netbrainstormid);
		g4Dao.insert("Netbrainstorm.saveNetbrainstorm", pDto);
		outDto.put("msg", "扩大问题添加成功！");
		outDto.put("success", new Boolean(true));
		return outDto;
	}
	
	

}
