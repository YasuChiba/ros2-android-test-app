package com.example.ros2_android_test_app;

import android.util.Log;
import android.widget.TextView;

import org.ros2.rcljava.node.BaseComposableNode;
import org.ros2.rcljava.subscription.Subscription;

public class ListenerNode extends BaseComposableNode {
    private final String topic;

    private final TextView listenerView;

    private Subscription<std_msgs.msg.String> subscriber;

    public ListenerNode(final String name, final String topic,
                        final TextView listenerView) {
        super(name);
        this.topic = topic;
        this.listenerView = listenerView;
        this.subscriber = this.node.<std_msgs.msg.String>createSubscription(
                std_msgs.msg.String.class, this.topic, msg
                        -> {
                    this.listenerView.setText("Hello ROS2 from Android: " + msg.getData() +
                            "\r\n" + listenerView.getText());

                });
    }
}
