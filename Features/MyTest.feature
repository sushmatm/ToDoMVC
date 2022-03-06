Feature: Test the ToDoMVC user URL for DT Testing


  Scenario Outline: Verify adding a todo to the list

    Given Open the given URL in a Browser

    When add the TODO '<items>' to the list

    Then check the added '<items>' is correct
    Examples:
      | items                                                |
      | eqeqwewewrewrewfrere454tgghjweejiwru32476389roi3jkhb |


  Scenario Outline: Verify marking the item in the list complete

    Given Open the given URL in a Browser
    When add the TODO '<item>' to the list
    Then mark the added '<item>' complete
    Examples:
      | item                                                 |
      | eqeqwewewrewrewfrere454tgghjweejiwru32476389roi3jkhb |

  Scenario Outline: Verify fetching all the items added in the list.

    Given Open the given URL in a Browser
    When add the TODO '<item1>', '<item2>' to the list
    Then select get the count of '<item2>' added
    Examples:
      | item1    | item2    |
      | AddItem1 | Additem2 |

  Scenario Outline: Verify fetching all the completed items added in the list complete

    Given Open the given URL in a Browser
    When add the TODO '<item1>', '<item2>' , '<item3>' to the list
    Then select the completed '<item1>'
    Examples:
      | item1    | item2    | item3    |
      | AddItem1 | Additem2 | Additem3 |

  Scenario Outline: Verify deleting the item added in the list.

    Given Open the given URL in a Browser
    When add the TODO '<item1>' to the list
    Then delete the item added '<item1>'
    Examples:
      | item1    | item2    | item3    |
      | AddItem1 | Additem2 | Additem3 |

