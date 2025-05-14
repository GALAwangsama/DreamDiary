DROP TABLE IF EXISTS dream_environment;
DROP TABLE IF EXISTS dream_sleep;
DROP TABLE IF EXISTS dream_todo;
DROP TABLE IF EXISTS dream_recommendation;

-- 环境参数表
CREATE TABLE dream_environment (
                                  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
                                  user_id  BIGINT(20) NOT NULL COMMENT '用户ID',
                                  temperature INT COMMENT '温度',
                                  humidity INT COMMENT '湿度',
                                  decibel INT COMMENT '分贝',
                                  light INT COMMENT '光线',
                                  air_quality VARCHAR(20) COMMENT '空气质量',
                                  carbon_dioxide_concentration INT COMMENT '二氧化碳浓度'
) COMMENT='环境参数表';
-- 睡眠参数表
CREATE TABLE dream_sleep (
                            id  BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
                            user_id  BIGINT(20) NOT NULL COMMENT '用户ID',
                            date DATE COMMENT '日期',
                            heart_rate INT COMMENT '心率',
                            oxygen_level INT COMMENT '血氧',
                            body_temperature INT COMMENT '体温',
                            lactate INT COMMENT '乳酸',
                            light_sleep_duration INT COMMENT '浅睡时长',
                            deep_sleep_duration INT COMMENT '深度睡眠时长',
                            rapid_eye_movement_duration INT COMMENT '快速眼动期',
                            wake_up_count INT COMMENT '清醒次数',
                            sleep_breathing_quality VARCHAR(255) COMMENT '睡眠呼吸质量'
) COMMENT='睡眠参数表';

-- 代办表
CREATE TABLE dream_todo (
                           id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
                           user_id BIGINT(20) NOT NULL COMMENT '用户ID',
                           content VARCHAR(255) COMMENT '代办内容',
                           is_completed TINYINT(1) DEFAULT 0 COMMENT '代办是否完成标识，0表示未完成，1表示已完成'
) COMMENT='代办表';

-- 推荐计划表
CREATE TABLE dream_recommendation (
                                     id  BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
                                     user_id  BIGINT(20)  NOT NULL COMMENT '用户ID',
                                     plan_content TEXT COMMENT '建议内容',
                                     plan_tags VARCHAR(255) COMMENT '建议标签（代办内容）'
) COMMENT='推荐计划表';
# -- 会员标记表
# CREATE TABLE member_tag (
#                             id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
#                             user_id BIGINT(20) COMMENT '用户ID',
#                             vip_level INT COMMENT '用户VIP等级',
#                             vip_expiry_date DATE COMMENT '用户VIP过期时间'
# ) COMMENT='会员标记表';