package com.group2.library_management.service;

import com.group2.library_management.entity.enums.BookStatus;
import com.group2.library_management.entity.enums.BorrowingStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service này chịu trách nhiệm cung cấp tên hiển thị (display name)
 * cho các giá trị Enum trong ứng dụng.
 * Tên bean "enumDisplayService" được sử dụng để gọi trực tiếp từ template Thymeleaf.
 */
@Service("enumDisplayService")
public class EnumDisplayService {

    private static final Map<BorrowingStatus, String> BORROWING_STATUS_NAMES = Map.ofEntries(
            Map.entry(BorrowingStatus.PENDING, "Chờ phê duyệt"),
            Map.entry(BorrowingStatus.APPROVED, "Đã phê duyệt"),
            Map.entry(BorrowingStatus.BORROWED, "Đang mượn"),
            Map.entry(BorrowingStatus.REJECTED, "Đã từ chối"),
            Map.entry(BorrowingStatus.RETURNED, "Đã trả"),
            Map.entry(BorrowingStatus.OVERDUE, "Quá hạn"),
            Map.entry(BorrowingStatus.LOST_REPORTED, "Báo mất"),
            Map.entry(BorrowingStatus.CANCELLED, "Đã hủy")
    );

    private static final Map<BookStatus, String> BOOK_STATUS_NAMES = Map.ofEntries(
            Map.entry(BookStatus.AVAILABLE, "Sẵn có"),
            Map.entry(BookStatus.BORROWED, "Đang được mượn"),
            Map.entry(BookStatus.RESERVED, "Đã đặt trước"),
            Map.entry(BookStatus.LOST, "Báo mất"),
            Map.entry(BookStatus.DAMAGED, "Hư hỏng"),
            Map.entry(BookStatus.REPAIRING, "Đang sửa chữa"),
            Map.entry(BookStatus.ARCHIVED, "Lưu kho")
    );

    /**
     * Lấy tên hiển thị cho BorrowingStatus.
     * @param status Trạng thái cần lấy tên.
     * @return Tên hiển thị Tiếng Việt, hoặc tên của Enum (ví dụ: "PENDING") nếu không tìm thấy.
     */
    public String getBorrowingStatusDisplayName(BorrowingStatus status) {
        return BORROWING_STATUS_NAMES.getOrDefault(status, status.name());
    }

    /**
     * Lấy tên hiển thị cho BookStatus.
     * @param status Trạng thái cần lấy tên.
     * @return Tên hiển thị Tiếng Việt, hoặc tên của Enum (ví dụ: "AVAILABLE") nếu không tìm thấy.
     */
    public String getBookStatusDisplayName(BookStatus status) {
        return BOOK_STATUS_NAMES.getOrDefault(status, status.name());
    }
}
