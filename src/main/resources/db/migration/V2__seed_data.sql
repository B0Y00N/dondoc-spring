-- 1. 기초 정보 테이블 (독립적인 테이블)
-- Categories 데이터
INSERT INTO `categories` (`id`, `name`, `icon`, `type`) VALUES
                                                            (1,'월급','income_salary','INCOME'),
                                                            (2,'부수입','income_side','INCOME'),
                                                            (3,'투자수익','income_invest','INCOME'),
                                                            (4,'용돈','income_allowance','INCOME'),
                                                            (5,'기타수입','income_etc','INCOME'),
                                                            (6,'식비','expense_food','EXPENSE'),
                                                            (7,'교통비','expense_bus','EXPENSE'),
                                                            (8,'쇼핑','expense_shopping','EXPENSE'),
                                                            (9,'문화생활','expense_movie','EXPENSE'),
                                                            (10,'의료/건강','expense_hospital','EXPENSE'),
                                                            (11,'교육','expense_education','EXPENSE'),
                                                            (12,'주거/통신','expense_house','EXPENSE'),
                                                            (13,'기타지출','expense_etc','EXPENSE');

-- Users 데이터
INSERT INTO `users` (`id`, `user_id`, `user_password`, `name`, `age`, `current_pig_level`, `current_house_level`, `monthly_income`, `target_expense_ratio`, `created_at`) VALUES
                                                                                                                                                                              (1,'testid01','testpw01','testname01',23,5,3,1500000,60,'2026-05-01 09:31:12'),
                                                                                                                                                                              (2,'testid02','testpw02','testname02',33,3,4,2000000,50,'2026-05-01 09:32:06');

-- Farms 데이터
INSERT INTO `farms` (`id`, `name`, `created_at`) VALUES
                                                     (1,'kb농장','2026-05-01 09:40:32'),
                                                     (2,'테스트농장','2026-05-01 09:40:44');


-- 2. 관계형 테이블 (외래 키 참조가 필요한 테이블)
-- Records 데이터 (User, Category 참조)
INSERT INTO `records` (`id`, `user_id`, `category_id`, `amount`, `description`, `memo`, `record_date`, `created_at`) VALUES
                                                                                                                         (1,1,1,1500000,NULL,NULL,'2026-04-20','2026-05-01 09:37:34'),
                                                                                                                         (2,2,8,20000,NULL,NULL,'2026-04-23','2026-05-01 09:38:42'),
                                                                                                                         (3,2,9,30000,NULL,NULL,'2026-04-24','2026-05-01 09:39:45');

-- Farm Members 데이터 (User, Farm 참조)
INSERT INTO `farm_members` (`id`, `user_id`, `farm_id`, `joined_at`) VALUES
                                                                         (1,1,1,'2026-05-01 09:41:31'),
                                                                         (2,2,1,'2026-05-01 09:41:45'),
                                                                         (3,2,2,'2026-05-01 09:41:58');

-- Monthly History 데이터 (User 참조)
INSERT INTO `monthly_history` (`id`, `user_id`, `target_month`, `avg_ratio`, `house_level`) VALUES
    (1,2,'2026-04',50,4);