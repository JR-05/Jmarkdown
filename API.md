### 类说明
| 类名     | 父类 | 包名                         |说明 |
| -------- | ---------------------------- | ---- | ---- |
| Markable | - | pers.conan.mdcoffee.markdown |Markable接口|
| BaseMark | Markable |   pers.conan.mdcoffee.markdown   | 基础标记     |
| BoldMark | TextMark | pers.conan.mdcoffee.markdown |粗体文本标记|
| CellMark      | BaseMark | pers.conan.mdcoffee.markdown | 单元格标记   |
| CodeMark      | BaseMark | pers.conan.mdcoffee.markdown | 代码标记     |
| DeleteMark | TextMark | pers.conan.mdcoffee.markdown |删除线标记|
| ImageMark | BaseMark | pers.conan.mdcoffee.markdown |图片标记|
| ItalicsMark | TextMark | pers.conan.mdcoffee.markdown |斜体文本标记|
| LinkMark | BaseMark | pers.conan.mdcoffee.markdown |标记|
| OrderMark | BaseMark | pers.conan.mdcoffee.markdown |有序列表标记|
| QuotationMark | BaseMark | pers.conan.mdcoffee.markdown |引用标记|
| TableHeadMark | BaseMark | pers.conan.mdcoffee.markdown |表头标记|
| TableMark | BaseMark | pers.conan.mdcoffee.markdown |表格标记|
| TableRowMark | BaseMark | pers.conan.mdcoffee.markdown |表行标记|
| TextMark | BaseMark | pers.conan.mdcoffee.markdown |文本标记|
| TitleMark | BaseMark | pers.conan.mdcoffee.markdown |标题标记|
| TodoListMark | BaseMark | pers.conan.mdcoffee.markdown |待办列表标记|
| TodoMark | BaseMark |     pers.conan.mdcoffee.markdown    |待办事项标记|
| TopMark | BaseMark | pers.conan.mdcoffee.markdown |顶层标记|
| UnderLineMark | TextMark | pers.conan.mdcoffee.markdown |下划线标记|
| UnOrderMark | BaseMark | pers.conan.mdcoffee.markdown |无序列表标记|

### 方法说明
| 类名 | 方法名 | 说明 |
| --- | --- | --- |
| Markable |void mark()|标记文本|
| BaseMark |String translate()|返回标记后的文本内容|