package com.example.genairabiloo.Enums;

import lombok.Getter;

@Getter
public enum Transcript {
    TRANSCRIPT_AUDIO("""
                1. Chuyển đổi nội dung trong file audio thành văn bản tương ứng với ngôn ngữ đó
                2. Ghi rõ phần nói của từng người không bỏ sót dù ngắn, thông qua đoạn hội thoại hãy xác định ai đang nói và tên tương ứng (ví dụ lan đang nói thì Lan:...),
                trong trường hợp không có tên nhắc trong audio chỉ phân biệt giọng nói và trả ra (Người thứ 1:....)
                3. Mỗi lần nói của từng người kết thúc thì xuống dòng, không gộp lời hai người vào cùng một dòng và chỉ trả về đoạn hội thoại
            """),
    TRANSCRIPT_AUDIO_SIMPLE("""
                Hãy chuyển audio âm thanh sang tiếng việt
            """),
    TRANSCRIPT_IMAGE("None");

    private String value;

    Transcript(String value) {
        this.value = value;
    }

}
