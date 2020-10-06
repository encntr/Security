<@c.page>

<a class="btn btn-dark" data-toggle="collapse" href="#collapseExampleNewTodo" role="button"
   aria-expanded="false"
   aria-controls="collapseExampleNewTodo">
    Add
</a>

<a class="btn btn-secondary" data-toggle="collapse" href="#collapseExampleSearch" role="button"
   aria-expanded="false"
   aria-controls="collapseExampleNewTodo">
    Search
</a>

<div class="collapse" id="collapseExampleNewTodo">
    <div class="form-group mt-3">
        <form method="post" action="/todo/todoList">
            <div class="row">
                <div class="col-auto">
                    <input type="text" name="title" class="form-control" placeholder="Title"/>
                </div>
                <div class="col-auto">
                    <textarea class="form-control" name="description" rows="1" placeholder="Description"></textarea>
                </div>
                <div class="col-auto">
                    <input type="date" name="closingDate" class="form-control" placeholder="closingDate"/>
                </div>
                <div class="col-auto">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-primary" type="submit">Create</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="collapse" id="collapseExampleSearch">
    <div class="form-group mt-3">
        <form method="post" action="/todo/list2">
            <div class="row">
                <div class="col-auto">
                    <input type="text" name="title" class="form-control" placeholder="Title"/>
                </div>
                <div class="col-auto">
                    <select name="status" class="custom-select">
                        <option value="">All Status</option>
                        <option>NEW</option>
                        <option>DOING</option>
                        <option>DONE</option>
                    </select>&nbsp;
                </div>
                <div class="col-auto">
                    <input type="date" name="from" class="form-control" placeholder="closingDate"/>
                </div>
                <div class="col-auto">
                    <input type="date" name="to" class="form-control" placeholder="closingDate"/>
                </div>

                <div class="col-auto">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-primary" type="submit">Search</button>
                </div>
            </div>
        </form>
    </div>
</div>


<h2 align="center" style="color:Black">List of Todo</h2>
</@c.page>