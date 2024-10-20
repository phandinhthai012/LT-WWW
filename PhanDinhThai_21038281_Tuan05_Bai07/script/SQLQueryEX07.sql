CREATE DATABASE QUANLYDANHMUC;
USE QUANLYDANHMUC;
use master
CREATE TABLE DANHMUC (
    MADM NVARCHAR(255) PRIMARY KEY,              -- Mã danh mục là khóa chính
    TENDANHMUC NVARCHAR(255),          -- Tên danh mục
    NGUOIQUANLY NVARCHAR(255),         -- Người quản lý
    GHICHU NVARCHAR(500)               -- Ghi chú
);

CREATE TABLE TINTUC (
    MATT NVARCHAR(255) PRIMARY KEY,              -- Mã tin tức là khóa chính
    TIEUDE NVARCHAR(255),              -- Tiêu đề
    NOIDUNGTT NVARCHAR(MAX),           -- Nội dung tin tức
    LIENKET NVARCHAR(255),             -- Liên kết
    MADM NVARCHAR(255),                          -- Mã danh mục (khóa ngoại tham chiếu đến DANHMUC)
    FOREIGN KEY (MADM) REFERENCES DANHMUC(MADM)  -- Thiết lập khóa ngoại
);
select * from DANHMUC
INSERT INTO DANHMUC (MADM, TENDANHMUC, NGUOIQUANLY, GHICHU) 
VALUES ('DM001', N'Công nghệ', N'Nguyễn Văn A', N'Tin tức về công nghệ'),
       ('DM002', N'Giáo dục', N'Trần Thị B', N'Tin tức giáo dục');

INSERT INTO TINTUC (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) 
VALUES ('TT001', N'Tin tức công nghệ', N'Nội dung tin tức về công nghệ...', 'http://congnghe.com', 'DM001'),
       ('TT002', N'Tin giáo dục mới', N'Nội dung tin tức giáo dục...', 'http://giaoduc.com', 'DM002');
SELECT * FROM TINTUC