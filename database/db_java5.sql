-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 15, 2022 lúc 04:32 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_java5`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(200) NOT NULL,
  `activated` bit(1) NOT NULL,
  `admin` bit(1) NOT NULL,
  `email` varchar(200) NOT NULL,
  `full_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `photo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`username`, `activated`, `admin`, `email`, `full_name`, `password`, `photo`) VALUES
('123123123', b'0', b'1', 'truongvan6322@gmail.com', 'Quy123', '+FA2gCyywlyJlwK9FOfNWw==', 'http://localhost:8080/assets/img/avt.jpg'),
('admin', b'1', b'1', 'truongvan6322@gmail.com', 'Xuân Quý', 'YUusPptmhlRTchtm2hehyw==', 'http://localhost:8080/assets/img/avt.jpg'),
('admin1', b'1', b'0', 'truongvan6322@gmail.com', 'Văn Trương', 'YUusPptmhlRTchtm2hehyw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('adminnew', b'1', b'0', 'truongvan6322@gmail.com', 'Nguyệt Nga', 'lH5VRxauC+6Hanju4FAgPw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('asd', b'1', b'0', 'truongvan6322@gmail.com', '1231', 'YUusPptmhlRTchtm2hehyw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('bnm', b'1', b'1', 'truongvan6322@gmail.com', 'Xuân Qúy', 'YUusPptmhlRTchtm2hehyw==', 'http://localhost:8080/assets/img/avt.jpg'),
('cc1', b'1', b'0', 'truongvan6322@gmail.com', 'Quy', 'YUusPptmhlRTchtm2hehyw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('crud', b'1', b'0', 'truongvan6322@gmail.com', 'Test thoi n', 'YUusPptmhlRTchtm2hehyw==', 'http://localhost:8080/assets/img/avt.jpg'),
('hass', b'1', b'0', 'truongvan6322@gmail.com', 'Test thoi 123', 'lH5VRxauC+6Hanju4FAgPw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('okroi', b'1', b'0', 'truongvan6322@gmail.com', 'ok', 'YUusPptmhlRTchtm2hehyw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('signup', b'1', b'1', 'truongvan6322@gmail.com', 'Quy', 'YUusPptmhlRTchtm2hehyw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('user', b'1', b'0', 'truongvan6322@gmail.com', 'Văn Trương', 'YUusPptmhlRTchtm2hehyw==', 'https://www.w3schools.com/howto/img_avatar.png'),
('xuanquy', b'1', b'0', 'truongvan6322@gmail.com', 'Test thoi ', 't5435', 'http://localhost:8080/assets/img/avt.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`category_id`, `name`) VALUES
(1, 'Clothes'),
(2, 'Book'),
(3, 'Phone'),
(4, 'Other'),
(7, 'ewrere123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `note` varchar(200) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `status` int(11) NOT NULL,
  `total` double NOT NULL,
  `username` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `customer_name`, `note`, `phone`, `status`, `total`, `username`) VALUES
(1, 'test name', 'khong', '0123123', 0, 60000000, 'cc1'),
(2, 'ok r', 'khong', '0339176342', 1, 30050000, 'cc1'),
(3, '213', '123', '1231', 1, 30000000, 'cc1'),
(4, 'quy', '123', '12313', 1, 30000000, 'cc1'),
(5, 'quy', '123', '123', 1, 30000000, 'cc1'),
(6, '123', '123', '123', 1, 30000000, 'cc1'),
(7, 'xuanquy', '123', '123', 1, 30000000, 'cc1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`order_id`, `product_id`, `price`, `quantity`, `total`) VALUES
(1, 2, 30000000, 2, 60000000),
(2, 2, 30000000, 1, 30000000),
(2, 6, 50000, 1, 50000),
(3, 2, 30000000, 1, 30000000),
(4, 2, 30000000, 1, 30000000),
(5, 2, 30000000, 1, 30000000),
(6, 2, 30000000, 1, 30000000),
(7, 2, 30000000, 1, 30000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `image` varchar(1000) NOT NULL,
  `price` double NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `available` bit(1) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `name`, `image`, `price`, `create_date`, `available`, `description`, `category_id`) VALUES
(2, 'Xiaomi Black Shark', 'xiaomi-black-shark-2-1-600x600.jpg', 30000000, '2022-06-14 10:22:30', b'1', 'Do not be scared of the\r\n', 3),
(3, 'Samsung A202', 'iphone-13-pro-xanh-la.jpg', 400000, '2022-06-14 10:22:38', b'1', 'Do not be scared of the', 3),
(4, 'Attack on titan', 'download (1).jfif', 90000, '2022-06-14 10:23:45', b'1', 'Do not be scared of the', 2),
(5, 'Tokyo Ghoul', 'download.jfif', 2000000, '2022-06-14 10:25:13', b'1', 'Do not be scared of', 2),
(6, 'Shirt', 'vgc-tee-print_v_logo-blk-01_0613a7d469fe4e05825ca0b55640de0b_large.webp', 50000, '2022-06-14 10:25:19', b'1', 'Do not be scared of the', 1),
(7, 'Jacket 12323232', 'smizbth2-1-o7x1-hinh-mat-truoc-0-large-jpeg.webp', 80000, '2022-06-14 10:26:35', b'1', 'Do not be scared of ', 1),
(8, 'Hyouka', '9IgqIUy.jpg', 90000, '2022-06-15 07:37:32', b'1', 'Do not be scared ', 2),
(9, 'Test', '195909638_262359105664557_4019114315410013355_n.jpg', 10000, '2022-06-13 21:35:10', b'0', 'Khong', 4),
(10, 'final', '596884.jpg', 20000000, '2022-06-13 21:26:12', b'1', 'ko', 4),
(12, 'testMul', '6952350af0e5077eb3e7cdeb5334af46.png', 123, '2022-06-11 19:59:06', b'1', 'ok', 1),
(15, '213', 'hinh-nen-anime-cho-laptop-2.jpg', 12, '2022-06-13 21:26:54', b'0', '123', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk3cjfcgb621qhahps1tre43e4` (`username`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`order_id`,`product_id`),
  ADD KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKk3cjfcgb621qhahps1tre43e4` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`);

--
-- Các ràng buộc cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
