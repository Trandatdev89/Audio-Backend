package com.example.genairabiloo.Enums;

import lombok.Getter;

@Getter
public enum Transcript {
    TRANSCRIPT_AUDIO("""
                1. Chuyển đổi nội dung trong file audio thành văn bản tiếng %s
                2. Ghi rõ phần nói của từng người không bỏ sót dù ngắn, thông qua đoạn hội thoại hãy xác định ai đang nói và tên tương ứng ví dụ lan đang nói thì Lan:...
                3. Tách dòng rõ ràng, không gộp lời hai người vào cùng một dòng và chỉ trả về đoạn hội thoại
            """),
    TRANSCRIPT_IMAGE("None");

    private String value;

    Transcript(String value) {
        this.value = value;
    }

}
