package com.example.kmmfoodrecipe01.domain.util

import com.example.kmmfoodrecipe01.domain.model.GenericMessageInfo
import com.example.kmmfoodrecipe01.domain.util.Queue

/**
 * Normally I would just make an extension function but KMP cannot use extension functions yet
 */
class GenericMessageInfoQueueUtil() {
    /**
     * Does this particular GenericMessageInfo already exist in the queue? We don't want duplicates
     */
    fun doesMessageAlreadyExistInQueue(queue: Queue<GenericMessageInfo>, messageInfo: GenericMessageInfo): Boolean{
        for(item in queue.items){
            if (item.id == messageInfo.id){
                return true
            }
        }
        return false
    }
}
