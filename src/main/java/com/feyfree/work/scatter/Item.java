package com.feyfree.work.scatter;

class Item {
    String pid = null;
    String type = null;
    Double score = 0.0;
    Double newScore = null;

    public Item(String pid, String type, Double score) {
        this.pid = pid;
        this.score = score;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setNewScore(Double newScore) {
        this.newScore = newScore;
    }

    public String getType() {
        return type;
    }

    public Double getScore() {
        return score;
    }

    public Double getNewScore() {
        return newScore;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return "Item{" +
                "pid='" + pid + '\'' +
                ", type='" + type + '\'' +
                ", score=" + score +
                ", newScore=" + newScore +
                '}';
    }
}
