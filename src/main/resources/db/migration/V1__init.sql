CREATE TABLE `users` (
                         `id` bigint PRIMARY KEY AUTO_INCREMENT,
                         `user_id` varchar(50) UNIQUE NOT NULL COMMENT '로그인 ID',
                         `user_password` varchar(255) NOT NULL,
                         `name` varchar(50) NOT NULL,
                         `age` int NOT NULL,
                         `current_pig_level` int DEFAULT 5,
                         `current_house_level` int DEFAULT 3 COMMENT '현재 집 레벨 (1~5)',
                         `monthly_income` bigint NOT NULL COMMENT '일일 예산 계산의 근거',
                         `target_expense_ratio` int NOT NULL COMMENT '일일 예산 계산의 근거',
                         `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `farms` (
                         `id` bigint PRIMARY KEY AUTO_INCREMENT,
                         `name` varchar(100) UNIQUE NOT NULL,
                         `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `farm_members` (
                                `id` bigint PRIMARY KEY AUTO_INCREMENT,
                                `user_id` bigint,
                                `farm_id` bigint,
                                `joined_at` timestamp DEFAULT (now())
);

CREATE TABLE `categories` (
                              `id` bigint PRIMARY KEY AUTO_INCREMENT,
                              `name` varchar(50) NOT NULL,
                              `icon` varchar(100),
                              `type` varchar(10) COMMENT 'INCOME, EXPENSE'
);

CREATE TABLE `records` (
                           `id` bigint PRIMARY KEY AUTO_INCREMENT,
                           `user_id` bigint,
                           `category_id` bigint,
                           `amount` bigint NOT NULL,
                           `description` text,
                           `memo` text,
                           `record_date` date NOT NULL,
                           `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `monthly_history` (
                                   `id` bigint PRIMARY KEY AUTO_INCREMENT,
                                   `user_id` bigint,
                                   `target_month` varchar(7) COMMENT 'YYYY-MM',
                                   `avg_ratio` float COMMENT '한 달간의 평균 페이스/비율',
                                   `house_level` int
);

ALTER TABLE `farm_members` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `farm_members` ADD FOREIGN KEY (`farm_id`) REFERENCES `farms` (`id`);

ALTER TABLE `records` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `records` ADD FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

ALTER TABLE `monthly_history` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
