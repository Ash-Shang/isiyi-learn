package com.isiyi.hikari.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isiyi.hikari.domain.IpDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IpMapper extends BaseMapper<IpDomain> {
}
