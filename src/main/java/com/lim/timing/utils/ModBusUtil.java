package com.lim.timing.utils;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @BelongsProject: timing
 * @BelongsPackage: com.lim.timing.utils
 * @Author: lim
 * @CreateTime: 2019-07-22 10:20
 * @Description: ModBus操作类
 */
public class ModBusUtil {

    // 获取一个Master，默认timeout为1000毫秒
    public static ModbusMaster getModBusMaster(String ip, int port) {
        // 设置主机tcp参数
        TcpParameters tcpParameters = new TcpParameters();
        try {
            tcpParameters.setHost(InetAddress.getByName(ip));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        tcpParameters.setPort(port);
        // tcp设置长连接
        tcpParameters.setKeepAlive(true);
        // 创建一个主机
        ModbusMaster m = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
        Modbus.setAutoIncrementTransactionId(true);
        return m;
    }

    // 获取一个Master，并设置timeout  单位：毫秒
    public static ModbusMaster getModBusMaster(String ip, int port, int ms) {
        ModbusMaster m = getModBusMaster(ip, port);
        m.setResponseTimeout(ms);
        return m;
    }



    // 读取对应寄存器的数据 readHoldingRegisters读取的写寄存器，功能码03
    // slaveId 从机地址 offset  寄存器读取开始地址 quantity  读取的寄存器数量
    public static int[] readHolding(int slaveId, int offset, int quantity, ModbusMaster m){
        try {

            if (!m.isConnected()) {
                m.connect();
            }

            // at next string we receive ten registers from a slave with id of 1 at offset of 0.
            return m.readHoldingRegisters(slaveId, offset, quantity);
        } catch (ModbusProtocolException e) {
            e.printStackTrace();
        } catch (ModbusNumberException e) {
            e.printStackTrace();
        } catch (ModbusIOException e) {
            e.printStackTrace();
        } finally {
            try {
                m.disconnect();
            } catch (ModbusIOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
