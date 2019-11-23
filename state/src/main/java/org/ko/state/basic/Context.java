package org.ko.state.basic;

/**
 * 状态上下文
 * 维护一个state实例，这个为实体当前的状态
 */
public class Context {

    /**
     * 当前的状态
     */
    private State state;

    /**
     * 构造函数
     * @param state
     */
    public Context(State state) {
        this.state = state;
    }

    /**
     * 请求状态
     */
    public void request() {
        state.handler(this);
    }

    //--set get

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
