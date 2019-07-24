package com.lim.timing.service.impl;

import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.lim.timing.model.ModbusConfigDO;
import com.lim.timing.model.ModbusConfigDORepository;
import com.lim.timing.service.ModBusPollService;
import com.lim.timing.utils.ModBusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @BelongsProject: timing
 * @BelongsPackage: com.lim.timing.service.impl
 * @Author: lim
 * @CreateTime: 2019-07-22 10:43
 * @Description: TODO
 */

@Service
public class ModBusPollServiceImpl implements ModBusPollService {


    private ModbusMaster m;

    // 实例化前获取动态ip及port
    public ModBusPollServiceImpl(/*@Value("${modbus.master.ip}")String ip,
                                 @Value("${modbus.master.port}")Integer port,*/
                                 @Autowired
                                 ModbusConfigDORepository modbusConfigDORepository) {
        // 根据application中配置通过@Value注入
        //m = ModBusUtil.getModBusMaster(ip,port);
        // 查询数据库中的ip、port
        ModbusConfigDO modbusConfigDO = modbusConfigDORepository.findById(1).get();
        m = ModBusUtil.getModBusMaster(modbusConfigDO.getMdIp(), modbusConfigDO.getMdPort());
    }

    @Override
    public void goData() {
        get1();
    }

    private void get1() {
        int slaveId = 1;// 从机地址
        int offset = 0;// 寄存器读取开始地址
        int quantity = 10;// 读取的寄存器数量
        System.out.print("从机1:");
        for (int value : ModBusUtil.readHolding(slaveId, offset, quantity, m)) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    private void get2() {
        int slaveId = 2;// 从机地址
        int offset = 0;// 寄存器读取开始地址
        int quantity = 10;// 读取的寄存器数量
        System.out.print("从机2:");
        for (int value : ModBusUtil.readHolding(slaveId, offset, quantity, m)) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    private void get3() {
        int slaveId = 3;// 从机地址
        int offset = 0;// 寄存器读取开始地址
        int quantity = 10;// 读取的寄存器数量
        System.out.print("从机3:");
        for (int value : ModBusUtil.readHolding(slaveId, offset, quantity, m)) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    private void get4() {
        int slaveId = 4;// 从机地址
        int offset = 0;// 寄存器读取开始地址
        int quantity = 10;// 读取的寄存器数量
        System.out.print("从机4:");
        for (int value : ModBusUtil.readHolding(slaveId, offset, quantity, m)) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    private void get5() {
        int slaveId = 5;// 从机地址
        int offset = 0;// 寄存器读取开始地址
        int quantity = 10;// 读取的寄存器数量
        System.out.print("从机5:");
        for (int value : ModBusUtil.readHolding(slaveId, offset, quantity, m)) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
