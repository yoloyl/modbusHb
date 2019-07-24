package com.lim.timing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @BelongsProject: timing
 * @BelongsPackage: com.lim.timing.model
 * @Author: lim
 * @CreateTime: 2019-07-22 15:24
 * @Description: TODO
 */

@Entity
@Table(name = "modbus_config")
public class ModbusConfigDO {

    @Id
    @Column(name = "md_id")
    private Integer mdId;
    @Column(name = "md_ip")
    private String mdIp;
    @Column(name = "md_port")
    private Integer mdPort;
    @Column(name = "md_timeout")
    private String mdTomeout;

    public Integer getMdId() {
        return mdId;
    }

    public void setMdId(Integer mdId) {
        this.mdId = mdId;
    }

    public String getMdIp() {
        return mdIp;
    }

    public void setMdIp(String mdIp) {
        this.mdIp = mdIp;
    }

    public Integer getMdPort() {
        return mdPort;
    }

    public void setMdPort(Integer mdPort) {
        this.mdPort = mdPort;
    }

    public String getMdTomeout() {
        return mdTomeout;
    }

    public void setMdTomeout(String mdTomeout) {
        this.mdTomeout = mdTomeout;
    }
}
