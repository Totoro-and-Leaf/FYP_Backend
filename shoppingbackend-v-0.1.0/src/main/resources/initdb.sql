-- CREATE DATABASE fyp;

-- product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_code` varchar(64) NOT NULL COMMENT 'product code',
  `product_name` varchar(64) NOT NULL COMMENT 'product name',
  `product_img_path` varchar(64) NULL COMMENT 'product image path',
  `product_description` varchar(64) DEFAULT NULL COMMENT 'product description',
  `product_currency` varchar(3) NOT NULL COMMENT 'product currency',
  `product_amount` bigint(20) NOT NULL COMMENT 'product amount',
  `product_status` varchar(16) NOT NULL COMMENT 'product status',
  `category_code` varchar(16) NOT NULL COMMENT 'category code',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT '{}' COMMENT 'key value for extra information',
  PRIMARY KEY (`product_code`),
  KEY `idx_product_status` (`product_status`),
  KEY `idx_category_code` (`category_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='product table'
;

-- order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_code` varchar(64) NOT NULL COMMENT 'order code',
  `amount` int(11) NOT NULL DEFAULT  0 COMMENT 'amount',
  `order_status` varchar(16) NOT NULL COMMENT 'order status',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `paid_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'paid time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT NULL COMMENT 'key value for extra information',
  PRIMARY KEY (`order_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='order table'
;

-- order item
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE IF NOT EXISTS `order_product` (
  `order_product_code` int(10) NOT NULL AUTO_INCREMENT COMMENT 'order product code',
  `order_code` varchar(64) NOT NULL COMMENT 'order code',
  `product_code` varchar(64) NOT NULL COMMENT 'product code',
  `quantity` varchar(64) NOT NULL COMMENT 'quantity',
  `memo` varchar(64) NULL COMMENT 'memo',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT NULL COMMENT 'key value for extra information',
  PRIMARY KEY (`order_product_code`),
  KEY `idx_order_code` (`order_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='order product table'
;