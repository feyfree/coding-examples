package com.feyfree.basic.ddd;

/**
 * 成员类型
 *
 * @author leilei
 */
public enum GroupMemberTypeEnum {

    /**
     * 组类型
     */
    GROUP {
        @Override
        public boolean isGroup() {
            return true;
        }
    },
    /**
     * 用户类型
     */
    USER {
        @Override
        public boolean isUser() {
            return true;
        }
    };


    public boolean isGroup() {
        return false;
    }

    public boolean isUser() {
        return false;
    }
}
