Use Deque to keep a non-increasing queue, so the first one will be the largest one. when the window size greater than k, we should check whether the largest element is the element of the beginning of the window, it yes, remove. Also we should start add the max into list when the window size reaches k.

tip : 1.the result list size is n - k + 1.
        2. we may keep duplicates in the deque.