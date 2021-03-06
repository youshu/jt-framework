package io.github.hylexus.jt808.codec.entity.req.resp;

import io.github.hylexus.jt.annotation.Transient;
import io.github.hylexus.jt.annotation.msg.resp.CommandField;
import io.github.hylexus.jt.data.resp.BytesValueWrapper;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

import static io.github.hylexus.jt.data.MsgDataType.BYTE;

/**
 * @author hylexus
 * Created At 2019-10-16 10:43 下午
 */
@Data
@Accessors(chain = true)
public class RespTerminalSettings {

    @CommandField(order = 2)
    private List<ParamItem> paramList;

    @CommandField(order = 1, targetMsgDataType = BYTE)
    private int totalParamCount;

    @Transient
    // ignored by annotation-processor
    private int transientValue;

    private int tmp;

    @Data
    @Accessors(chain = true)
    public static class ParamItem {
        @CommandField(order = 1)
        private BytesValueWrapper<?> msgId;

        @CommandField(order = 2, targetMsgDataType = BYTE)
        private int bytesCountOfContentLength;

        @CommandField(order = 3)
        private BytesValueWrapper msgContent;

        public ParamItem(BytesValueWrapper msgId, BytesValueWrapper msgContent) {
            this.msgId = msgId;
            this.msgContent = msgContent;
            this.bytesCountOfContentLength = msgContent.getAsBytes().length;
        }
    }

}
