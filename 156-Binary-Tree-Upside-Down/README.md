keep four pointers, left, right, parent, node.

so current node left = last right node and node' right = last parent node. then moving forward.

    1                    2                   4
  /     \      ->     /     \     ->      /  \
null null          3       1         5       2
                                                /     \
                                              3        1