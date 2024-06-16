package io.kanthis;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.DriverCommand;

import com.google.common.collect.ImmutableMap;

import io.kanthis.dto.DockPosition;
import io.kanthis.dto.NavigateDirection;
import io.kanthis.dto.ScrollAmount;
import io.kanthis.dto.VisualState;
import io.kanthis.dto.ZoomUnit;

public interface WinDriverCommand extends DriverCommand {
    String GET_ANNOTATION_TARGET = "annotationTarget";
    String GET_LABELED_BY = "labeledBy";
    String GET_CONTROLLER_FOR = "controllerFor";
    String GET_DESCRIBED_BY = "describedBy";
    String GET_FLOWS_TO = "flowsTo";
    String FOCUS = "focus";
    String NAVIGATE_DIRECTION = "navigate_direction";
    String SET_DOCK_POSITION = "dock_position";
    String GET_DROP_EFFECTS = "dropEffects";
    String GET_GRABBED_ITEMS = "grabbedItems";
    String GET_DROP_TARGET_EFFECTS = "dropTargetEffects";
    String EXPAND_COLLAPSE = "expandCollapse";
    String GET_CONTAINING_GRID = "containingGrid";
    String GET_GRID_ITEM = "gridItem";
    String INVOKE = "invoke";
    String GET_SUPPORTED_VIEWS = "supportedViews";
    String GET_VIEW_NAME = "viewName";
    String SET_CURRENT_VIEW = "currentView";
    String SET_RANGE_VALUE = "rangeValue";
    String SCROLL_INTO_VIEW = "scrollIntoView";
    String SCROLL = "scroll";
    String SET_SCROLL_PERCENT = "scrollPercent";
    String SELECT = "select";
    String ADD_SELECTION = "addSelection";
    String REMOVE_SELECTION = "removeSelection";
    String GET_SELECTION_CONTAINER = "selectionContainer";
    String GET_FIRST_SELECTED = "firstSelected";
    String GET_LAST_SELECTED = "lastSelected";
    String GET_CURR_SELECTED = "currSelected";
    String ANNOTATION_OBJECTS = "annotationObjects";
    String GET_SPREADSHEET_ITEM = "spreadSheetItem";
    String GET_ROW_HEADER_ITEMS = "rowHeaderItems";
    String GET_COLUMN_HEADER_ITEMS = "columnHeaderItems";
    String GET_ROW_HEADERS = "rowHeaders";
    String GET_COLUMN_HEADERS = "columnHeaders";
    String TOGGLE = "toggle";
    String ZOOM = "zoom";
    String ZOOM_BY_UNIT = "zoomByUnit";
    String MOVE = "move";
    String RESIZE = "resize";
    String ROTATE = "rotate";
    String SET_VALUE = "setValue";
    String REALIZE = "realize";
    String SET_VISUAL_STATE = "visualState";
    String WAIT_INPUT_IDLE = "waitInputIdle";
    String CLOSE_WINDOW = "closeWindow";
    String SET_WINDOW_RECT = "setWindowRect";
    String BRING_ON_TOP = "bringOnTop";
    String GET_WINDOW_RECT = "getWindowRect";

    static CommandPayload GET_ANNOTATION_TARGET(String id) {
        return new CommandPayload(GET_ANNOTATION_TARGET, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_LABELED_BY(String id) {
        return new CommandPayload(GET_LABELED_BY, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_CONTROLLER_FOR(String id) {
        return new CommandPayload(GET_CONTROLLER_FOR, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_DESCRIBED_BY(String id) {
        return new CommandPayload(GET_DESCRIBED_BY, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_FLOWS_TO(String id) {
        return new CommandPayload(GET_FLOWS_TO, ImmutableMap.of("id", id));
    }

    static CommandPayload FOCUS(String id) {
        return new CommandPayload(FOCUS, ImmutableMap.of("id", id));
    }

    static CommandPayload NAVIGATE_DIRECTION(String id, NavigateDirection direction) {
        return new CommandPayload(NAVIGATE_DIRECTION, ImmutableMap.of("id", id, "value", direction.value()));
    }

    static CommandPayload SET_DOCK_POSITION(String id, DockPosition position) {
        return new CommandPayload(SET_DOCK_POSITION, ImmutableMap.of("id", id, "value", position.value()));
    }

    static CommandPayload GET_DROP_EFFECTS(String id) {
        return new CommandPayload(GET_DROP_EFFECTS, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_GRABBED_ITEMS(String id) {
        return new CommandPayload(GET_GRABBED_ITEMS, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_DROP_TARGET_EFFECTS(String id) {
        return new CommandPayload(GET_DROP_TARGET_EFFECTS, ImmutableMap.of("id", id));
    }

    static CommandPayload EXPAND(String id) {
        return new CommandPayload(EXPAND_COLLAPSE, ImmutableMap.of("id", id, "value", true));
    }

    static CommandPayload COLLAPSE(String id) {
        return new CommandPayload(EXPAND_COLLAPSE, ImmutableMap.of("id", id, "value", false));
    }

    static CommandPayload GET_CONTAINING_GRID(String id) {
        return new CommandPayload(GET_CONTAINING_GRID, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_GRID_ITEM(String id, int row, int column) {
        return new CommandPayload(GET_GRID_ITEM, ImmutableMap.of("id", id, "row", row, "column", column));
    }

    static CommandPayload INVOKE(String id) {
        return new CommandPayload(INVOKE, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_SUPPORTED_VIEWS(String id) {
        return new CommandPayload(GET_SUPPORTED_VIEWS, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_VIEW_NAME(String id, int viewId) {
        return new CommandPayload(GET_VIEW_NAME, ImmutableMap.of("id", id, "viewId", viewId));
    }

    static CommandPayload SET_CURRENT_VIEW(String id, int viewId) {
        return new CommandPayload(SET_CURRENT_VIEW, ImmutableMap.of("id", id, "value", viewId));
    }

    static CommandPayload SET_RANGE_VALUE(String id, double value) {
        return new CommandPayload(SET_RANGE_VALUE, ImmutableMap.of("id", id, "value", value));
    }

    static CommandPayload SCROLL_INTO_VIEW(String id) {
        return new CommandPayload(SCROLL_INTO_VIEW, ImmutableMap.of("id", id));
    }

    static CommandPayload SCROLL(String id, ScrollAmount horizontalAmount, ScrollAmount verticalAmount) {
        return new CommandPayload(SCROLL, ImmutableMap.of("id", id, "horizontalAmount", horizontalAmount.value(), "verticalAmount", verticalAmount.value()));
    }

    static CommandPayload SET_SCROLL_PERCENT(String id, double horizontalPercent, double verticalPercent) {
        return new CommandPayload(SET_SCROLL_PERCENT, ImmutableMap.of("id", id, "horizontalPercent", horizontalPercent, "verticalPercent", verticalPercent));
    }

    static CommandPayload SELECT(String id) {
        return new CommandPayload(SELECT, ImmutableMap.of("id", id));
    }

    static CommandPayload ADD_SELECTION(String id) {
        return new CommandPayload(ADD_SELECTION, ImmutableMap.of("id", id));
    }

    static CommandPayload REMOVE_SELECTION(String id) {
        return new CommandPayload(REMOVE_SELECTION, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_SELECTION_CONTAINER(String id) {
        return new CommandPayload(GET_SELECTION_CONTAINER, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_FIRST_SELECTED(String id) {
        return new CommandPayload(GET_FIRST_SELECTED, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_LAST_SELECTED(String id) {
        return new CommandPayload(GET_LAST_SELECTED, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_CURR_SELECTED(String id) {
        return new CommandPayload(GET_CURR_SELECTED, ImmutableMap.of("id", id));
    }

    static CommandPayload ANNOTATION_OBJECTS(String id) {
        return new CommandPayload(ANNOTATION_OBJECTS, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_SPREADSHEET_ITEM(String id, String name) {
        return new CommandPayload(GET_SPREADSHEET_ITEM, ImmutableMap.of("id", id, "name", name));
    }

    static CommandPayload GET_ROW_HEADER_ITEMS(String id) {
        return new CommandPayload(GET_ROW_HEADER_ITEMS, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_COLUMN_HEADER_ITEMS(String id) {
        return new CommandPayload(GET_COLUMN_HEADER_ITEMS, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_ROW_HEADERS(String id) {
        return new CommandPayload(GET_ROW_HEADERS, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_COLUMN_HEADERS(String id) {
        return new CommandPayload(GET_COLUMN_HEADERS, ImmutableMap.of("id", id));
    }

    static CommandPayload TOGGLE(String id) {
        return new CommandPayload(TOGGLE, ImmutableMap.of("id", id));
    }

    static CommandPayload ZOOM(String id, double value) {
        return new CommandPayload(ZOOM, ImmutableMap.of("id", id, "value", value));
    }

    static CommandPayload ZOOM_BY_UNIT(String id, ZoomUnit value) {
        return new CommandPayload(ZOOM_BY_UNIT, ImmutableMap.of("id", id, "value", value.value()));
    }

    static CommandPayload MOVE(String id, double x, double y) {
        return new CommandPayload(MOVE, ImmutableMap.of("id", id, "x", x, "y", y));
    }

    static CommandPayload RESIZE(String id, double width, double height) {
        return new CommandPayload(RESIZE, ImmutableMap.of("id", id, "width", width, "height", height));
    }

    static CommandPayload ROTATE(String id, double value) {
        return new CommandPayload(ROTATE, ImmutableMap.of("id", id, "value", value));
    }

    static CommandPayload SET_VALUE(String id, String value) {
        return new CommandPayload(SET_VALUE, ImmutableMap.of("id", id, "value", value));
    }

    static CommandPayload REALIZE(String id) {
        return new CommandPayload(REALIZE, ImmutableMap.of("id", id));
    }

    static CommandPayload SET_VISUAL_STATE(String id, VisualState value) {
        return new CommandPayload(SET_VISUAL_STATE, ImmutableMap.of("id", id, "value", value.value()));
    }

    static CommandPayload WAIT_INPUT_IDLE(String id, int value) {
        return new CommandPayload(WAIT_INPUT_IDLE, ImmutableMap.of("id", id, "value", value));
    }

    static CommandPayload CLOSE_WINDOW(String id) {
        return new CommandPayload(CLOSE_WINDOW, ImmutableMap.of("id", id));
    }

    static CommandPayload SET_WINDOW_SIZE(String id, Dimension dimension) {
        return new CommandPayload(SET_WINDOW_RECT, ImmutableMap.of("id", id, "width", dimension.width, "height", dimension.height));
    }

    static CommandPayload SET_WINDOW_POSITION(String id, Point point) {
        return new CommandPayload(SET_WINDOW_RECT, ImmutableMap.of("id", id, "x", point.x, "y", point.y));
    }

    static CommandPayload BRING_ON_TOP(String id) {
        return new CommandPayload(BRING_ON_TOP, ImmutableMap.of("id", id));
    }

    static CommandPayload GET_WINDOW_RECT(String id) {
        return new CommandPayload(GET_WINDOW_RECT, ImmutableMap.of("id", id));
    }
}
