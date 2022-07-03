package com.feyfree.work.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 连接详情
 *
 * @author leilei
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ConnectionDetail implements Serializable {

    private static final long serialVersionUID = -3032300740622035423L;

    private String ip;

    private String connected;

    private long timeout;

    private String desc;

    @Override
    public String toString() {
        return "连接信息{" +
                "ip='" + ip + '\'' +
                ", connected=" + connected +
                ", timeout=" + timeout +
                ", desc='" + desc + '\'' +
                '}';
    }
}
