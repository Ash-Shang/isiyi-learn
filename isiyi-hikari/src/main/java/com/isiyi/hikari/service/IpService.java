package com.isiyi.hikari.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isiyi.hikari.domain.IpDomain;
import com.isiyi.hikari.mapper.IpMapper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
public class IpService extends ServiceImpl<IpMapper, IpDomain> implements IService<IpDomain> {



}
